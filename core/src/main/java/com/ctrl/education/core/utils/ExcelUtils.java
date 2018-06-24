package com.ctrl.education.core.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ctrl.education.core.exception.AlohaException;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.file.UploadUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * com.ctrl.education.core.utils
 *
 * @author liyang
 * @name ExcelUtils
 * @description
 * @date 2018-06-10 下午6:57
 */
public class ExcelUtils {
    private static final String EXTENSION_XLS = "xls";
    private static final String EXTENSION_XLSX = "xlsx";
    private static final String XLS_CONTENT_TYPE = "application/vnd.ms-excel";
    private static final String XLSX_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);

    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        if (workbook != null) ;
        downLoadExcel(fileName, response, workbook);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new AlohaException(e.getMessage());
        }
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) ;
        downLoadExcel(fileName, response, workbook);
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new AlohaException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new AlohaException(e.getMessage());
        }
        return list;
    }

    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new AlohaException("excel文件不能为空");
        } catch (Exception e) {
            throw new AlohaException(e.getMessage());
        }
        return list;
    }

    private static boolean preReadCheck(String filePath, String contentType)
            throws FileNotFoundException, FileFormatException, NotOLE2FileException {

        // 常规检查
        Boolean res = true;
        File file = new File(filePath);
        if (!file.exists()) {
            res = false;
            throw new FileNotFoundException("传入的文件不存在：" + filePath);
        }
        if (!(filePath.endsWith(EXTENSION_XLS) || filePath.endsWith(EXTENSION_XLSX))) {
            res = false;
            throw new FileFormatException("传入的文件不是excel");
        }
        if (!((filePath.endsWith(EXTENSION_XLS) & XLS_CONTENT_TYPE.equals(contentType))
                || (filePath.endsWith(EXTENSION_XLSX) & XLSX_CONTENT_TYPE.equals(contentType)))) {
            res = false;
            throw new NotOLE2FileException("传入的文件可能损坏");
        }
        return res;
    }

    public static Result uploadExcel(MultipartFile file,String foldPath,HttpServletRequest request) throws IOException{
        MultipartFile[] files = new MultipartFile[1];
        files[0] = file;

        Result r = new UploadUtils().uploadFileToLocal(files, foldPath, request);
        JSONArray urls = JSONUtil.parseArray(r.get("url"));
        JSONObject url = JSONUtil.parseObj(urls.get(0));
        try {

            preReadCheck(ImageConstant.ROOT_PATH + url.get("url"), file.getContentType());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
        JSONObject result = new JSONObject();
        result.put("filePath", url.get("url"));
        return r.ok().put("result", result);
    }


}

package com.ctrl.education.core.utils.file;

import cn.hutool.core.date.DateUtil;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * com.ctrl.education.core.utils.file
 *
 * @name FileUtil
 * @description
 * @date 2018-06-27 14:31
 */
public class FileUtil {

    public FileUtil() {
    }

    /**
     * 创建文件夹
     *
     * @param path
     * @return 不存在, 创建目录返回true;存在,返回true
     */
    public static boolean createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return true;
    }

    /**
     * 创建一个文件，内容为content 文件目录不存在，则创建目录
     *
     * @param path     文件的存放路径
     * @param filename 文件名
     * @param content  内容
     * @param append   追加标识
     * @return 成功返回true；否则返回false
     */
    public static File writeFile(String path, String filename, String content,
                                 boolean append) {
        File file = new File(path + File.separatorChar + filename);
        FileWriter writer = null;

        try {

            file.createNewFile();

            writer = new FileWriter(file, append);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {

        }

        return file;
    }


    /**
     * 创建一个文件，内容为content 文件目录不存在，则创建目录
     *
     * @param filenUrl 文件名
     * @param content  内容
     * @param append   追加标识
     * @return 成功返回true；否则返回false
     */
    public static File writeFile(String filenUrl, String content,
                                 boolean append) {
        File file = new File(filenUrl);
        FileWriter writer = null;

        try {

            file.createNewFile();

            writer = new FileWriter(file, append);
            writer.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    /**
     * 创建一个文件，内容为content 文件目录不存在，则创建目录，并以追加方式写文件
     * <p>
     * <p>
     * 文件的存放路径
     * <p>
     * 文件名
     *
     * @param content 内容
     */
    public static File writeFile(String filenUrl, String content) {
        return writeFile(filenUrl, content, true);
    }


    /**
     * 批量写入文件文件
     *
     * @param filenUrl    文件的存放路径
     * @param contentList 内容集合
     * @param isNewline   是否换行（内容与内容之间）
     * @return 成功返回true；否则返回false
     */
    public static File batchWriteFile(String filenUrl, List<String> contentList, boolean isNewline) {
        String content = "";
        //拼接内容
        for (String str : contentList) {
            if (isNewline) {
                str += "\n";
            }
            content += str;
        }
        return writeFile(filenUrl, content, true);
    }

    /**
     * 创建一个文件，内容为content 文件目录不存在，则创建目录，并以追加方式写文件
     *
     * @param path     文件的存放路径
     * @param filename 文件名
     * @param content  内容
     * @return 成功返回true；否则返回false

     */
    public static File writeFile(String path, String filename, String content) {
        return writeFile(path, filename, content, true);
    }

    /**
     * 创建一个文件，内容为content 文件目录不存在，则创建目录
     *
     * @param path     文件的存放路径
     * @param filename 文件名
     * @param content  内容
     * @return 成功返回true；否则返回false

     */
    public static File writeFile(String path, String filename, byte[] content) {
        File file = new File(path + filename);
        FileOutputStream fos = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fos = new FileOutputStream(file, true);
            fos.write(content);
            fos.flush();
            fos.close();
        } catch (IOException e) {

        }

        return file;
    }

    /**
     * 创建一个文件，内容为content 文件目录不存在，则创建目录 内容为一个Vector的内包含的byte[]内容
     *
     * @param path     文件的存放路径
     * @param filename 文件名
     * @param content  内容
     * @return 成功返回true；否则返回false

     */
    public static File writeFile(String path, String filename, Vector content) {
        File file = new File(path + filename);
        FileOutputStream fos = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fos = new FileOutputStream(file);
            for (int i = 0; i < content.size(); i++) {
                fos.write((byte[]) content.get(i));
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {

        }

        return file;
    }

    /**
     * 拷贝一个文件到另一个目录
     *
     * @param from
     * @param to
     * @return
     */
    public static boolean copyFile(String from, String to) {
        File fromFile, toFile;
        fromFile = new File(from);
        toFile = new File(to);
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            toFile.createNewFile();
            fis = new FileInputStream(fromFile);
            fos = new FileOutputStream(toFile);
            int bytesRead;
            byte[] buf = new byte[4 * 1024]; // 4K buffer
            while ((bytesRead = fis.read(buf)) != -1) {
                fos.write(buf, 0, bytesRead);
            }
            fos.flush();
            fos.close();
            fis.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;

    }

    /**
     * @param folderPath 文件路径 (只删除此路径的最末路径下所有文件和文件夹)
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath);    // 删除完里面所有内容
            String filePath = folderPath;
            File myFilePath = new File(filePath);
            myFilePath.delete();        // 删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定文件夹下所有文件
     *
     * @param path 文件夹完整绝对路径
     */
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);    // 先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);    // 再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 文件读到字符串中
     *
     * @param filename 要转换的文件
     * @return 返回 文件内容

     */
    public static String getFileString(String filename) {
        StringBuffer sb = new StringBuffer("");
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            while (br.ready()) {
                line = br.readLine();
                sb.append(line);
            }
        } catch (IOException e) {

        }
        return sb.toString();
    }

    /**
     * 文件的行数
     *
     * @param filename 文件名
     * @return 文件行数
     */
    public static int getFileCount(String filename) {
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while (br.ready()) {
                br.readLine();
                count++;
            }
        } catch (IOException e) {

        }
        return count;
    }

    /**
     * 文件修改日期
     *
     * @param filename 文件名
     * @return 日期
     */
    public static String getFileModDate(String filename) {
        File f = new File(filename);
        Date dt = new Date(f.lastModified());
        return DateUtil.format(dt, "yyyyMMdd");

    }

    /**
     * 文件修改日期
     *
     * @param filename 文件名
     * @return 日期
     */
    public static String getFileModTime(String filename) {
        File f = new File(filename);
        Date dt = new Date(f.lastModified());
        return DateUtil.format(dt, "HHmmss");

    }

    // public static void main(String[] args) {
    // File f = new File("c:\\oc.xml");
    //
    // Date dt = new Date(f.lastModified());
    // System.out.println("time:" + getFileModTime("c:\\oc.xml"));
    //
    // System.out.println("count:" + getFileCount("c:\\oc.xml"));
    // }

    /**
     * 读取到字节数组0
     *
     * @param filePath //路径
     * @throws IOException
     */
    @SuppressWarnings("resource")
    public static byte[] getContent(String filePath) throws IOException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        fi.close();
        return buffer;
    }

    /**
     * 读取到字节数组1
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(String filePath) throws IOException {

        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException(filePath);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    /**
     * 读取到字节数组2
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray2(String filePath) throws IOException {

        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException(filePath);
        }

        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray3(String filePath) throws IOException {

        FileChannel fc = null;
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(filePath, "r");
            fc = rf.getChannel();
            MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                    fc.size()).load();
            //System.out.println(byteBuffer.isLoaded());
            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                // System.out.println("remain");
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                rf.close();
                fc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取txt里的单行内容
     *
     * @param fileP 文件路径
     */
    public static String readTxtFile(String fileP) {
        try {

            String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + ".." + File.separator + ".." + File.separator;    //项目路径
            filePath = filePath.replaceAll("file:/", "");
            filePath = filePath.replaceAll("%20", " ");
            filePath = filePath.trim() + fileP.trim();
            if (filePath.indexOf(":") != 1) {
                filePath = File.separator + filePath;
            }
            String encoding = "utf-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {        // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);    // 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    return lineTxt;
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件,查看此路径是否正确:" + filePath);
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
        }
        return "";
    }

    /**
     * 写txt里的单行内容
     *
     * @param fileP 文件路径
     * @param content  写入的内容
     */
    public static void writeFileText(String fileP, String content) {
        String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + ".." + File.separator + ".." + File.separator;    //项目路径
        filePath = (filePath.trim() + fileP.trim()).substring(6).trim();
        if (filePath.indexOf(":") != 1) {
            filePath = File.separator + filePath;
        }
        try {
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(content);
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

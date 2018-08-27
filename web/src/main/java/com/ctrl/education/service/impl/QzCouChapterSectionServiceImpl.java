package com.ctrl.education.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzCouChapterMapper;
import com.ctrl.education.dao.QzCouChapterSectionMapper;
import com.ctrl.education.model.QzCouChapter;
import com.ctrl.education.model.QzCouChapterSection;
import com.ctrl.education.service.IQzCouChapterSectionService;
import com.ctrl.education.service.IQzCouChapterService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 小节表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzCouChapterSectionServiceImpl extends ServiceImpl<QzCouChapterSectionMapper, QzCouChapterSection> implements IQzCouChapterSectionService {
    /**
     * 增加小节
     *
     * @param qzCouChapterSection
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addChapterSection(QzCouChapterSection qzCouChapterSection) {
        String[] document = {"txt", "doc", "docx", "pdf", "wps", "xls", "ppt", "xlsx", "pptx"};
        String[] video = {"drc", "dsm", "dsv", "dsa", "dss", "vob", "ifo", "d2v", "flv","fla", "fli", "flc", "flic", "ivf", "mkv", "mpg", "mpeg", "mpe",
                "m1v", "m2v", "mpv2", "mp2v", "dat", "ts", "tp", "tpr", "pva", "pss", "mp4", "m4v", "m4p", "m4b", "3gp", "3gpp", "3g2", "3gp2", "ogm", "mov",
                "qt", "amr", "rat", "dvd", "rt", "rp", "smi", "smil", "rm", "ram", "rmvb", "rpm", "roq", "swf", "smk", "bik", "wmv", "wmp", "wm", "asf",
                "avi", "asx", "m3u", "pls", "wvx", "wax", "wmx", "mpcpl"};
        qzCouChapterSection.setSysCode(RandomUtil.randomString(4));
        qzCouChapterSection.setState(1);
        qzCouChapterSection.setSysUserId(ShiroKit.getUser().getId());
        String fileType = qzCouChapterSection.getFileUrl().substring(qzCouChapterSection.getFileUrl().lastIndexOf(".") + 1);
        if (Arrays.asList(document).contains(fileType)) {
            qzCouChapterSection.setType(0);
        } else if (Arrays.asList(video).contains(fileType)) {
            qzCouChapterSection.setType(1);
        }
        int count = this.baseMapper.insert(qzCouChapterSection);
        if (count > 0) {
            String id = qzCouChapterSection.getId();
            Map<String, Object> map = new HashMap<>();
            map.put("msg", SystemConstant.ADD_SUCCESS);
            map.put("code", SystemConstant.SUCCESS);
            map.put("result", id);
            return Result.ok(map);
        } else {
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
    }
}

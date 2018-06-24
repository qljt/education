package com.ctrl.education.core.validator.group;

import javax.validation.GroupSequence;

/**
 * com.aloha.app.core.validator.group
 *
 * @author zgl
 * @name Group
 * @description 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 * @date 2018-03-01 11:09
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {
}

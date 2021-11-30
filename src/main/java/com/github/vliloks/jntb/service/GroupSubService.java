package com.github.vliloks.jntb.service;

import com.github.vliloks.jntb.javarushclient.dto.GroupDiscussionInfo;
import com.github.vliloks.jntb.repository.entity.GroupSub;

public interface GroupSubService {

    GroupSub save(Long chatId, GroupDiscussionInfo groupDiscussionInfo);
}

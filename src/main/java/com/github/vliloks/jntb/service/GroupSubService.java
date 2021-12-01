package com.github.vliloks.jntb.service;

import com.github.vliloks.jntb.javarushclient.dto.GroupDiscussionInfo;
import com.github.vliloks.jntb.repository.entity.GroupSub;

import java.util.Optional;

public interface GroupSubService {

    GroupSub save(Long chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub groupSub);
    Optional<GroupSub> findById(Integer id);
}

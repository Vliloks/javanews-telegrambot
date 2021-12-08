package com.github.vliloks.jntb.javarushclient;

import com.github.vliloks.jntb.javarushclient.dto.GroupDiscussionInfo;
import com.github.vliloks.jntb.javarushclient.dto.GroupInfo;
import com.github.vliloks.jntb.javarushclient.dto.GroupRequestArgs;
import com.github.vliloks.jntb.javarushclient.dto.GroupsCountRequestArgs;

import java.util.List;

public interface JavaRushGroupClient {

    List<GroupInfo> getGroupList(GroupRequestArgs requestArgs);
    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs);
    Integer getGroupCount(GroupsCountRequestArgs countRequestArgs);
    GroupDiscussionInfo getGroupById(Integer id);
    Integer findLastArticleId(Integer groupSub);
}

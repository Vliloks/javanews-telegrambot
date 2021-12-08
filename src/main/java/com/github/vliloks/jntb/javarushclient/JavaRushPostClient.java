package com.github.vliloks.jntb.javarushclient;

import com.github.vliloks.jntb.javarushclient.dto.PostInfo;

import java.util.List;

public interface JavaRushPostClient {

    List<PostInfo> findNewPosts(Integer groupId, Integer lastPostId);
}

package com.sunlight.webservice.domain;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        /** 
        ���� �׽�Ʈ �ڵ忡 ������ ��ġ�� �ʱ� ���� 
        �׽�Ʈ �޼ҵ尡 ������ ���� respository ��ü ���� �ڵ�
        **/
        postsRepository.deleteAll();
    }

    @Test
    public void �Խñ�����_�ҷ�����() {
        //given
    	LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("�׽�Ʈ �Խñ�")
                .content("�׽�Ʈ ����")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
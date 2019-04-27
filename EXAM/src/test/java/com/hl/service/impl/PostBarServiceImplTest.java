package com.hl.service.impl;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.PostBar;
import com.hl.entity.Userinfo;
import com.hl.service.PostBarService;

public class PostBarServiceImplTest extends BaseTest{
	
	@Autowired
	private PostBarService ps;

	@Test
	public void testAddPostBar() {
		Userinfo user = new Userinfo();
		user.setUserid(6);
		String title = "c";
		String content = "caaa";
		String reward = "1";
		ps.addPostBar(title, content, reward, user);
	}

	@Test
	public void testUpdatePostBarByPbid() {
		fail("Not yet implemented");
	}

	@Test
	public void testListPostBarByTitle() {
		String page = "1";
		String limit = "10";
		String title = "hl";
		Map<String, Object> listPostBarByTitle = ps.listPostBarByTitle(page, limit, title);
		List<PostBar> list = (List<PostBar>)listPostBarByTitle.get("list");
		for (PostBar postBar : list) {
			System.out.println(postBar);
		}
	}

	@Test
	public void testShowPostBarByPbid() {

		String pbid = "2";
		ps.showPostBarDetailByPbid(pbid);
	}

}

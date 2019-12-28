package jsh.proejct.board.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jsh.project.board.restapi.dao.BoardMapper;

// @RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private BoardMapper boardDao;

	@Test
	void contextLoads() {
	}

	@Test
	void boardTest(){
		System.out.println(boardDao.totalCount());
	}

}

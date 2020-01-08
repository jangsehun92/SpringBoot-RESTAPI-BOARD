package jsh.proejct.board.restapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DemoApplicationTests {

	// @Autowired
	// private BoardMapper boardMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void boardTest(){
		System.out.println("boardMapper.totalCount()");
	}

}

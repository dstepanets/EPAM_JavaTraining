package org.lesson1.tester;

public class MyTest {

	@Before
	public void before1(){
		System.out.println("before 1");
	}

	@After
	public void after(){
		System.out.println("after");
	}

	@BeforeAll
	public void beforeAll(){
		System.out.println("before ALL");
	}
	@AfterAll
	public void afterAll(){
		System.out.println("after ALL");
	}

	@Test
	public void test1(){
		System.out.println("* test1");
	}

	@Test
	public void test2(){
		System.out.println("* test2");
	}

	@Test(expectedException = NullPointerException.class, expectedMessage = "LOL")
	public void test3(){
		System.out.println("* test3");
	}

	private void noTest(){
		System.out.println("not a test");
	}





}

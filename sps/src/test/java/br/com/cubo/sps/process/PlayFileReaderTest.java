package br.com.cubo.sps.process;

import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cubo.sps.main.Main;
import br.com.cubo.sps.vo.Match;
import junit.framework.Assert;

public class PlayFileReaderTest {

	PLayFileReader reader;
	InputStream stream;
	boolean exists;
	boolean contains;
	String className; 
	
	
	
	
	@Before
	public void init() {
		reader = new PLayFileReader();
		stream = Main.class.getClassLoader().getResourceAsStream("play-test-log.log");
		exists = false;
		contains = true;
		className = "Match";
	}

	@Test
	public void read(){
		List<Match> matchList = reader.read(stream);
		Assert.assertEquals(exists, matchList.isEmpty());
		Assert.assertEquals(contains, matchList.get(0).getClass().toString().contains(className));
	}

}

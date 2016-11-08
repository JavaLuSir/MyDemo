package org.javalusir.hadoop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

public class HadoopDemo {
	private FileSystem fs = null;
	@Before
	public void initFileSystem() throws IOException, InterruptedException, URISyntaxException{
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.118.137:9000");
		conf.set("dfs.replication","1");
		fs=FileSystem.get(new URI("hdfs://192.168.118.137:9000"), conf, "hadoop");
		//fs = FileSystem.get(conf);
	}
	@Test
	public void addFile() throws IllegalArgumentException, IOException{
		fs.copyFromLocalFile(new Path("E:\\download\\AtomSetup.exe"), new Path("/user/upload/Atom.exe"));
	}
	@Test
	public void getFile() throws IllegalArgumentException, IOException{
		//fs.create(new Path("/user/upload/Atom.exe"));
		fs.copyToLocalFile(false,new Path("/user/upload/Atom.exe"), new Path("E:\\download\\Atom2.exe"),true);
	}
	@Test
	public void renameFile() throws IllegalArgumentException, IOException{
		fs.rename(new Path("/user/upload/Atom.exe"), new Path("/user/upload/Atomrename.exe"));
	}
	@Test
	public void mkdir() throws IllegalArgumentException, IOException{
		fs.mkdirs(new Path("/user/mkdir"));
	}
	@Test
	public void delFile() throws IllegalArgumentException, IOException{
		fs.delete(new Path("/user/map/output"),true);
	}
	@Test
	public void showList() throws FileNotFoundException, IllegalArgumentException, IOException{
		RemoteIterator<LocatedFileStatus> remoteItera = fs.listFiles(new Path("/user/upload"), true);
		while (remoteItera.hasNext()) {
			LocatedFileStatus l=remoteItera.next();

			System.out.println(l.getPath());
		}
		
	}
}

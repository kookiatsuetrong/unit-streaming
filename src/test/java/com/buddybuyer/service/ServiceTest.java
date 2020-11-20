package com.buddybuyer.service;

import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.buddybuyer.model.Creator;
import com.buddybuyer.model.Genre;
import com.buddybuyer.model.Media;
import com.buddybuyer.model.Viewer;
import com.buddybuyer.service.Main;

public class ServiceTest {
	public ServiceTest() {
		Genre g1 = new Genre("G1");
		Genre g2 = new Genre("G2");
		Creator c1 = new Creator("C1");
		Creator c2 = new Creator("C2");
		Creator c3 = new Creator("C3");
		media = new HashSet<>();
		Media m1 = new Media("M001", 1, g1, c1);
		Media m2 = new Media("M002", 2, g1, c2);
		Media m3 = new Media("M003", 3, g1, c3);
		media.add(m1);
		media.add(m2);
		media.add(m3);
		media.add( new Media("M004", 4, g2, c1) );
		media.add( new Media("M005", 5, g2, c2) );
		media.add( new Media("M006", 4, g2, c3) );
		viewer = new HashSet<>();
		Viewer v1 = new Viewer("V1");
		v1.likeMedia(m1);
		v1.likeMedia(m2);
		viewer.add(v1);
		Viewer v2 = new Viewer("V2");
		v2.likeMedia(m2);
		v2.likeMedia(m3);
		viewer.add(v2);
	}
	Set<Media> media;
	Set<Viewer> viewer;
	public void testA001() {
		Main m = new Main(media, viewer);
		Assert.assertEquals( 1, m.count(1) );
	}
	public void testA002() {
		Main m = new Main(media, viewer);
		Assert.assertEquals( 0, m.count(0) );
	}
	public void testA003() {
		Main m = new Main(media, viewer);
		Assert.assertEquals( 2, m.count(4) );
	}
	public void testB001() {
		Main m = new Main(media, viewer);
		Set<String> r = m.listTitle(2);
		Set<String> e = new HashSet<>();
		e.add("M002");
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testB002() {
		Main m = new Main(media, viewer);
		Set<String> r = m.listTitle(4);
		Set<String> e = new HashSet<>();
		e.add("M006");
		e.add("M004");
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testB003() {
		Main m = new Main(media, viewer);
		Set<String> r = m.listTitle(0);
		Set<String> e = new HashSet<>();
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testC001() {
		Main m = new Main(media, viewer);
		Set<Media> r = m.listMedia(2);
		Set<Media> e = new HashSet<>();
		e.add( new Media("M002", 2, null, null) );
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testC002() {
		Main m = new Main(media, viewer);
		Set<Media> r = m.listMedia(4);
		Set<Media> e = new HashSet<>();
		e.add( new Media("M006", 4, null, null) );
		e.add( new Media("M004", 4, null, null) );
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testC003() {
		Main m = new Main(media, viewer);
		Set<Media> r = m.listMedia(0);
		Set<Media> e = new HashSet<>();
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testD001() {
		Main m = new Main(media, viewer);
		Set<Media> r = m.listMediaAtLeast(5);
		Set<Media> e = new HashSet<>();
		e.add( new Media("M005", 5, null, null) );
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testD002() {
		Main m = new Main(media, viewer);
		Set<Media> r = m.listMediaAtLeast(4);
		Set<Media> e = new HashSet<>();
		e.add( new Media("M004", 4, null, null) );
		e.add( new Media("M005", 5, null, null) );
		e.add( new Media("M006", 6, null, null) );
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testD003() {
		Main m = new Main(media, viewer);
		Set<Media> r = m.listMediaAtLeast(7);
		Set<Media> e = new HashSet<>();
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testE001() {
		
		
	}
}

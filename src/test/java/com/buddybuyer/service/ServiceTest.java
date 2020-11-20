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
		Media m4 = new Media("M004", 4, g2, c1);
		Media m5 = new Media("M005", 5, g2, c2);
		Media m6 = new Media("M006", 4, g2, c3);
		media.add(m1);
		media.add(m2);
		media.add(m3);
		media.add(m4);
		media.add(m5);
		media.add(m6);
		viewer = new HashSet<>();
		Viewer v1 = new Viewer("V1", 21);
		v1.likeMedia(m1);
		v1.likeMedia(m2);
		viewer.add(v1);
		Viewer v2 = new Viewer("V2", 21);
		v2.likeMedia(m2);
		v2.likeMedia(m3);
		viewer.add(v2);
		Viewer v3 = new Viewer("V3", 25);
		viewer.add(v3);
		Viewer v4 = new Viewer("V4", 26);
		viewer.add(v4);
		Viewer v5 = new Viewer("V5", 25);
		viewer.add(v5);
		Viewer v6 = new Viewer("V6", 25);
		viewer.add(v6);
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
		Main m = new Main(media, viewer);	
		Media m1 = new Media("M001", 1, null, null);
		Media m2 = new Media("M002", 2, null, null);
		Media m3 = new Media("M003", 3, null, null);
		Media m4 = new Media("M004", 4, null, null);
		Media m5 = new Media("M005", 5, null, null);
		Media m6 = new Media("M006", 4, null, null);
		Viewer v1 = new Viewer("V1");
		v1.likeMedia(m1);
		v1.likeMedia(m2);
		Viewer v2 = new Viewer("V2");
		v2.likeMedia(m2);
		v2.likeMedia(m3);
		Set<Media> r = m.listCommon(v1, v2);
		Set<Media> e = new HashSet<>();
		e.add(m2);
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testE002() {
		Main m = new Main(media, viewer);	
		Media m1 = new Media("M001", 1, null, null);
		Media m2 = new Media("M002", 2, null, null);
		Media m3 = new Media("M003", 3, null, null);
		Media m4 = new Media("M004", 4, null, null);
		Media m5 = new Media("M005", 5, null, null);
		Media m6 = new Media("M006", 4, null, null);
		Viewer v1 = new Viewer("V1");
		v1.likeMedia(m1);
		v1.likeMedia(m2);
		v1.likeMedia(m3);
		Viewer v2 = new Viewer("V2");
		v2.likeMedia(m2);
		v2.likeMedia(m3);
		Set<Media> r = m.listCommon(v1, v2);
		Set<Media> e = new HashSet<>();
		e.add(m3);
		e.add(m2);
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testE003() {
		Main m = new Main(media, viewer);	
		Media m1 = new Media("M001", 1, null, null);
		Media m2 = new Media("M002", 2, null, null);
		Media m3 = new Media("M003", 3, null, null);
		Media m4 = new Media("M004", 4, null, null);
		Media m5 = new Media("M005", 5, null, null);
		Media m6 = new Media("M006", 4, null, null);
		Viewer v1 = new Viewer("V1");
		v1.likeMedia(m1);
		v1.likeMedia(m2);
		v1.likeMedia(m3);
		v1.likeMedia(m4);
		Viewer v2 = new Viewer("V2");
		v2.likeMedia(m2);
		v2.likeMedia(m4);
		Set<Media> r = m.listCommon(v1, v2);
		Set<Media> e = new HashSet<>();
		e.add(m4);
		e.add(m2);
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testE004() {
		Main m = new Main(media, viewer);	
		Media m1 = new Media("M001", 1, null, null);
		Media m2 = new Media("M002", 2, null, null);
		Media m3 = new Media("M003", 3, null, null);
		Media m4 = new Media("M004", 4, null, null);
		Media m5 = new Media("M005", 5, null, null);
		Media m6 = new Media("M006", 4, null, null);
		Viewer v1 = new Viewer("V1");
		v1.likeMedia(m1);
		v1.likeMedia(m2);
		v1.likeMedia(m3);
		v1.likeMedia(m4);
		Viewer v2 = new Viewer("V2");
		v2.likeMedia(m5);
		v2.likeMedia(m6);
		Set<Media> r = m.listCommon(v1, v2);
		Set<Media> e = new HashSet<>();
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testE005() {
		Main m = new Main(media, viewer);	
		Media m1 = new Media("M001", 1, null, null);
		Media m2 = new Media("M002", 2, null, null);
		Media m3 = new Media("M003", 3, null, null);
		Media m4 = new Media("M004", 4, null, null);
		Media m5 = new Media("M005", 5, null, null);
		Media m6 = new Media("M006", 4, null, null);
		Viewer v1 = new Viewer("V1");
		v1.likeMedia(m1);
		v1.likeMedia(m2);
		v1.likeMedia(m3);
		v1.likeMedia(m4);
		Viewer v2 = new Viewer("V2");
		v2.likeMedia(m1);
		v2.likeMedia(m2);
		v2.likeMedia(m3);
		v2.likeMedia(m4);
		Set<Media> r = m.listCommon(v1, v2);
		Set<Media> e = new HashSet<>();
		e.add(m4);
		e.add(m3);
		e.add(m1);
		e.add(m2);
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testF001() {
		Genre g1 = new Genre("G1");
		Genre g2 = new Genre("G2");
		Media m1 = new Media("M001", 1, g1, null);
		Media m2 = new Media("M002", 2, g1, null);
		Media m3 = new Media("M003", 3, g1, null);
		Media m4 = new Media("M004", 4, g2, null);
		Media m5 = new Media("M005", 5, g2, null);
		Media m6 = new Media("M006", 4, g2, null);
		Set<Media> all = new HashSet<>();
		all.add(m1); all.add(m2); all.add(m3);
		all.add(m4); all.add(m5); all.add(m6);
		Main m = new Main(all, viewer);
		Viewer v1 = new Viewer("V1");
		v1.likeGenre(g1);
		Set<String> r = m.listMedia(v1);
		Set<String> e = new HashSet<>();
		e.add("M001");
		e.add("M002");
		e.add("M003");
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testF002() {
		Genre g1 = new Genre("G1");
		Genre g2 = new Genre("G2");
		Media m1 = new Media("M001", 1, g1, null);
		Media m2 = new Media("M002", 2, g1, null);
		Media m3 = new Media("M003", 3, g1, null);
		Media m4 = new Media("M004", 4, g2, null);
		Media m5 = new Media("M005", 5, g2, null);
		Media m6 = new Media("M006", 4, g2, null);
		Set<Media> all = new HashSet<>();
		all.add(m1); all.add(m2); all.add(m3);
		all.add(m4); all.add(m5); all.add(m6);
		Main m = new Main(all, viewer);
		Viewer v1 = new Viewer("V1");
		v1.likeGenre(g2);
		Set<String> r = m.listMedia(v1);
		Set<String> e = new HashSet<>();
		e.add("M004");
		e.add("M005");
		e.add("M006");
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testF003() {
		Genre g1 = new Genre("G1");
		Genre g2 = new Genre("G2");
		Media m1 = new Media("M001", 1, g1, null);
		Media m2 = new Media("M002", 2, g1, null);
		Media m3 = new Media("M003", 3, g1, null);
		Media m4 = new Media("M004", 4, g2, null);
		Media m5 = new Media("M005", 5, g2, null);
		Media m6 = new Media("M006", 4, g2, null);
		Set<Media> all = new HashSet<>();
		all.add(m1); all.add(m2); all.add(m3);
		all.add(m4); all.add(m5); all.add(m6);
		Main m = new Main(all, viewer);
		Viewer v1 = new Viewer("V1");
		v1.likeGenre(g1);
		v1.likeGenre(g2);
		Set<String> r = m.listMedia(v1);
		Set<String> e = new HashSet<>();
		e.add("M001");
		e.add("M002");
		e.add("M003");
		e.add("M004");
		e.add("M005");
		e.add("M006");
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testF004() {
		Genre g1 = new Genre("G1");
		Genre g2 = new Genre("G2");
		Media m1 = new Media("M001", 1, g1, null);
		Media m2 = new Media("M002", 2, g1, null);
		Media m3 = new Media("M003", 3, g1, null);
		Media m4 = new Media("M004", 4, g2, null);
		Media m5 = new Media("M005", 5, g2, null);
		Media m6 = new Media("M006", 4, g2, null);
		Set<Media> all = new HashSet<>();
		all.add(m1); all.add(m2); all.add(m3);
		all.add(m4); all.add(m5); all.add(m6);
		Main m = new Main(all, viewer);
		Viewer v1 = new Viewer("V1");
		Set<String> r = m.listMedia(v1);
		Set<String> e = new HashSet<>();
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testF005() {
		Genre g1 = new Genre("G1");
		Genre g2 = new Genre("G2");
		Genre g3 = new Genre("G3");
		Media m1 = new Media("M001", 1, g1, null);
		Media m2 = new Media("M002", 2, g1, null);
		Media m3 = new Media("M003", 3, g1, null);
		Media m4 = new Media("M004", 4, g2, null);
		Media m5 = new Media("M005", 5, g2, null);
		Media m6 = new Media("M006", 4, g2, null);
		Set<Media> all = new HashSet<>();
		all.add(m1); all.add(m2); all.add(m3);
		all.add(m4); all.add(m5); all.add(m6);
		Main m = new Main(all, viewer);
		Viewer v1 = new Viewer("V1");
		v1.likeGenre(g3);
		Set<String> r = m.listMedia(v1);
		Set<String> e = new HashSet<>();
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testG001() {
		Main m = new Main(media, viewer);
		Set<String> r = m.listViewers(21);
		Set<String> e = new HashSet<>();
		e.add("V1");
		e.add("V2");
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testG002() {
		Main m = new Main(media, viewer);
		Set<String> r = m.listViewers(17);
		Set<String> e = new HashSet<>();
		Assert.assertTrue( e.containsAll(r) );
	}
	public void testG003() {
		Main m = new Main(media, viewer);
		Set<String> r = m.listViewers(25);
		Set<String> e = new HashSet<>();
		e.add("V3");
		e.add("V5");
		e.add("V6");
		Assert.assertTrue( e.containsAll(r) );
	}
}

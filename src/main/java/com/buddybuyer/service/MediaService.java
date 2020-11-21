package com.buddybuyer.service;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import com.buddybuyer.media.Media;
import com.buddybuyer.media.Genre;
import com.buddybuyer.media.Viewer;
import com.buddybuyer.media.Creator;

public class MediaService {
	private final Set<Media> media;
	private final Set<Viewer> viewers;

	public MediaService(Set<Media> media, Set<Viewer> viewers) {
		this.media = media;
		this.viewers = viewers;
	}
	/*
	A: คำสั่ง int count(int rating) จะนับจำนวน media ที่มี rating ตามที่กำหนด
	*/
	int count(int rating) {
		return -1; // Remove this line to write your code.
	}
	
	/*
	B: คำสั่ง Set<String> listTitle(int rating) จะส่งค่ากลับเป็นชื่อ media 
	   ทั้งหมดที่มี rating ตามที่กำหนด
	*/
	Set<String> listTitle(int rating) {
		return null; // Remove this line to write your code.
	}
	
	/*
	C: คำสั่ง Set<Media> listMedia(int rating) จะส่งค่ากลับเป็น media 
	   ทั้งหมดที่มี rating ตามที่กำหนด
	*/
	Set<Media> listMedia(int rating) {
		return null; // Remove this line to write your code.
	}
	
	/*
	D: คำสั่ง Set<Media> listMediaAtLeast(int rating) จะส่งค่ากลับเป็น media 
	   ทั้งหมดที่มี rating อย่างน้อยเป็นค่าที่กำหนดให้
	*/
	Set<Media> listMediaAtLeast(int rating) {
		return null; // Remove this line to write your code.
	}
	
	/*
	E: คำสั่ง Set<Media> listCommon(Viewer a, Viewer b) จะส่งค่ากลับเป็น media
	   ทั้งหมดที่เป็น Favourite ร่วมกันของ a และ b
	*/
	Set<Media> listCommon(Viewer a, Viewer b) {
		return null; // Remove this line to write your code.
	}
	
	/*
	F: The method Set<String> listMedia(Viewer viewer) should return titles
	   of all the media which belong to one of the viewer's favourite genres
	*/
	Set<String> listMedia(Viewer viewer) {
		return null; // Remove this line to write your code.
	}
	
	/*
	G: The method Set<String> listViewers(int age) should return
	   name of all viewers of the specified age
	*/
	Set<String> listViewers(int age) {
		return null; // Remove this line to write your code.
	}
	
	/*
	U: The method Set<Media> recommendMedia(Viewer viewer) should return 
	   all the media that meet all the following criteria:
	   1. Have a rating of four or higher
	   2. Belong to one of the viewer's favourite genres
	   3. Belong to favourite media's list of at least one differrent user of 
	      the same age
	*/
	Set<Media> recommendMedia(Viewer viewer) {
		return null; // Remove this line to write your code.
	}
	
	/*
	X: The method Set<String> suggestMedia(Viewer viewer) should return titles
	   of all the media that meet all the following criteria:
	   1. Have a rating of four or higher
	   2. Belong to one of the viewer's favourite genres
	   3. Belong to favourite media's list of at least one differrent user of 
	      the same age
	*/
	Set<String> suggestMedia(Viewer viewer) {
		return null; // Remove this line to write your code.
	}
	
	/*
	Y: The method Set<String> suggestMedia(Viewer viewer, int rating) should 
	   return titles of all the media that meet all the following criteria:
	   1. Have exactly the rating specified in the method argument
	   2. Belong to one of the viewer's favourite genres
	   3. Belong to favourite media's list of at least one differrent user of 
	      the same age
	*/
	Set<String> suggestMedia(Viewer viewer, int rating) {
		return null; // Remove this line to write your code.
	}
	
	/*
	Z: The method Set<String> suggestMedia(Viewer viewer, Creator creator) 
	   should return title of all the media that meet all the following criteria:
	   1. Have a rating of four or higher
	   2. Belong to one of the viewer's favourite genres
	   3. Belong to favourite media's list of at least one different reader of 
	      the same age
	   4. Have been created by the creator specified in the method argument
	*/
	Set<String> suggestMedia(Viewer viewer, Creator creator) {
		return null; // Remove this line to write your code.
	}
	
}

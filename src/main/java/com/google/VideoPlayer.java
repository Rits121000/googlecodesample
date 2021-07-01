package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {   // how to remove commas?
    System.out.println("Here's a list of all available videos:");
    List<String> list1 = new ArrayList<String>();
    for(int i = 0; i < videoLibrary.getVideos().size();i++) {
      Video video1 = videoLibrary.getVideos().get(i);
      list1.add(video1.getTitle() + " (" + video1.getVideoId() + ") " + video1.getTags());
      //System.out.println(video1.getTitle() + " (" + video1.getVideoId() + ") " + video1.getTags());
    }
    Collections.sort(list1);
    for(int i = 0; i < list1.size(); i++) {
      System.out.println(list1.get(i));
    }
  }
  String current;
  public void playVideo(String videoId) {
    if(current != (null)) {
      if((videoLibrary.getVideo(videoId)) != (null)) {
        System.out.println("Stopping video: " + current);
      }
    }
    if((videoLibrary.getVideo(videoId)) != (null)){
      System.out.println("Playing video: " + videoLibrary.getVideo(videoId).getTitle());
      current = videoLibrary.getVideo(videoId).getTitle();
    }else {
      System.out.println("Cannot play video: Video does not exist");
    }

  }

  boolean is_stop_true = false;

  public void stopVideo() {
    if(current != null) {
      System.out.println("Stopping video: " + current);
      current = null;
      is_stop_true = true;
    }else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    Random rnd = new Random();
    List<String> video_titles = new ArrayList<String>();
    for(int i = 0; i < videoLibrary.getVideos().size();i++) {
      Video video1 = videoLibrary.getVideos().get(i);
      video_titles.add(video1.getVideoId());
    }
    int int_random = rnd.nextInt(videoLibrary.getVideos().size());
    playVideo(video_titles.get(int_random));
   // System.out.println("playRandomVideo needs implementation");
  }

  boolean is_pause_true = false;

  public void pauseVideo() {
    if(current == null){
      System.out.println("Cannot pause video: No video is currently playing");
    }else {
      if (is_pause_true) {
        System.out.println("Video already paused: " + current);
      } else {
        System.out.println("Pausing video: " + current);
        is_pause_true = !is_pause_true;
      }
    }
  }

  public void continueVideo() {
    if (current == null) {
      System.out.println("Cannot continue video: No video is currently playing");
    }else {
      if (is_pause_true) {
        System.out.println("Continuing video: " + current);
      } else {
        System.out.println("Cannot continue video: Video is not paused");
      }
    }
  }

  public void showPlaying() {
    if (current != null)
    {
      List<String> list1 = new ArrayList<String>();

      for (int i = 0; i < videoLibrary.getVideos().size(); i++) {
        Video video1 = videoLibrary.getVideos().get(i);
        list1.add(video1.getTitle() + " (" + video1.getVideoId() + ") " + video1.getTags());
        if (list1.get(i).contains(current)) {
          if(is_stop_true && is_pause_true ){
            System.out.println("Currently playing: " + list1.get(i));
          }else {
            if (!is_pause_true) {
              System.out.println("Currently playing: " + list1.get(i) + " - PAUSED");
            } else {
              System.out.println("Currently playing: " + list1.get(i));
            }
          }
        }
      }
    }else{
      System.out.println("No video is currently playing");
    }


  }

  List<String> playlists = new ArrayList<String>();

  public void createPlaylist(String playlistName) {

    boolean in_list = false;
    for(int i = 0; i < playlists.size(); i++){
      if (playlistName.toUpperCase().equals(playlists.get(i))) {
        in_list = true;
        System.out.println("Cannot create playlist: A playlist with the same name already exists");
      }
    }
    if(in_list == false) {
      System.out.println("Successfully created new playlist: " + playlistName);
      playlists.add(playlistName.toUpperCase());
    }

  }

  List<String> video_ids = new ArrayList<String>();

  public void addVideoToPlaylist(String playlistName, String videoId) {
    boolean in_list = false;
    for(int i = 0; i < video_ids.size(); i++){
      if (videoId.equals(video_ids.get(i))) {
        in_list = true;
        System.out.println("Cannot add video to " +  playlistName + ": " + "Video already added");
      }
    }
    if(in_list == false) {
      System.out.println("Added video to " + playlistName + ": " + videoLibrary.getVideo(videoId).getTitle());
      video_ids.add(videoId);
    }


  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}
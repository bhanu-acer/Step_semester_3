import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        songs = new String[capacity];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);

        playlist.addSong("Song A");
        playlist.addSong("Song B");

        String[] copy = playlist.getSongs();
        copy[0] = "Hacked";

        System.out.println(Arrays.toString(playlist.getSongs()));
        System.out.println("Song count: " + playlist.getSongCount());
    }
}
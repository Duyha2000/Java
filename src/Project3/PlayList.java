package Project3;

public class PlayList {
    private String name;
    private GenericLinkedList<Song> songs;

    public PlayList(String name) {
        this.name = name;
        this.songs = new GenericLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public GenericLinkedList<Song> getSongs() {
        return songs;
    }
}
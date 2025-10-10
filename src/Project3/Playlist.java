package Project3;

public class Playlist {
    private final String name;
    private final GenericLinkedList<Song> songs;
    private int currentIndex = -1;

    public Playlist(String name) {
        this.name = name;
        this.songs = new GenericLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.addLast(song);
        if (currentIndex == -1) currentIndex = 0;
    }

    public boolean removeSong(Song song) {
        int index = songs.indexOf(song);
        if (index == -1) return false;

        songs.remove(index);
        if (songs.isEmpty()) {
            currentIndex = -1;
        } else if (index <= currentIndex) {
            currentIndex = Math.max(-1, currentIndex - 1);
        }
        return true;
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }

    public int size() {
        return songs.size();
    }


    public Song getCurrentSong() {
        if (currentIndex < 0 || currentIndex >= songs.size()) return null;
        return songs.get(currentIndex);
    }


    public void nextSong() {
        if (songs.isEmpty()) return;
        currentIndex = (currentIndex + 1) % songs.size();
    }


    public void previousSong() {
        int n = songs.size();
        if (n == 0) return;
        if (currentIndex == -1) {
            currentIndex = 0;
            return;
        }
        currentIndex = (currentIndex - 1 + n) % n;
    }

    public GenericLinkedList<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return name;
    }
}

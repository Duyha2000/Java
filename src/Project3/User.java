package Project3;

public class User {
    private final String username;
    private final String password;
    private final GenericLinkedList<Playlist> playlists;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.playlists = new GenericLinkedList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addPlaylist(Playlist playlist) {
        if (playlist == null) throw new IllegalArgumentException("playlist cannot be null");
        playlists.addLast(playlist);
    }

    // App cần số lượng playlists
    public int getPlaylistCount() {
        return playlists.size();
    }

    public GenericLinkedList<Playlist> getPlaylists() {
        return playlists;
    }

    @Override
    public String toString() {
        return username;
    }
}

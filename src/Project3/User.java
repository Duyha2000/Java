package Project3;

public class User {
    private String username;
    private String password;
    private GenericLinkedList<PlayList> playlists;

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

    public void addPlayList(PlayList playlist) {
        playlists.add(playlist);
    }

    public GenericLinkedList<PlayList> getPlaylistsCount() {
        return playlists;
    }
}


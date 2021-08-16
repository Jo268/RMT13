public class Song {
    public String interpret;
    public String title;
    public int laengeInSekunden;
    public void drucke(){
        System.out.println(interpret, title, laengeInSekunden);
    }
    static class MusicPlayer {
        public static void main (String[] args) {
            Song timeLord = new Song();
            timeLord.interpret = "focojo";
            timeLord.title = "timeLord";
            timeLord.laengeInSekunden = 420;
            timeLord.drucke();
        }
    }
}


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File Sleep_away = new File("C:\\Users\\renan\\Music\\Arquivos wav\\Sleep-Away.wav");
        File eu_me_lembro = new File("C:\\Users\\renan\\Music\\Arquivos wav\\Eu me Lembro.wav");
        File[] musics = {Sleep_away, eu_me_lembro};
        AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(musics[0]);
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(musics[1]);
        AudioInputStream[] audioStreamsList = {audioStream1, audioStream2};
        Scanner scanner = new Scanner(System.in);
        Clip clip = AudioSystem.getClip();
        int response;

        do {
            System.out.println("What do you want to do? ");
            System.out.print("1 - Select a song\n2 - Select action\n3 - Exit\n");
            response = scanner.nextInt();
            switch (response){
                case 1 -> Main.selectSong(audioStreamsList, clip);
                case 2 -> {
                    if (clip.isOpen()) {
                        Main.selectAction(clip);
                    }
                    else {
                        System.out.println("Please, select a song in order to do an action");
                    }
                }
                default -> {}
            }
        }while(response != 3);
    }

    public static void selectSong(AudioInputStream[] audioStreamsList, Clip clip) throws IOException, LineUnavailableException{
        Scanner scanner = new Scanner(System.in);
        int response;
        clip.close();
        System.out.println("Select a song");
        System.out.print("1 - Sleep Away\n2 - Eu Me Lembro\n");
        response = scanner.nextInt();
        switch (response){
            case 1 -> clip.open(audioStreamsList[0]);
            case 2 -> clip.open(audioStreamsList[1]);
            default -> clip.close();
        }
    }
    public static void selectAction(Clip clip){
        Scanner scanner = new Scanner(System.in);
        int response;
        do {
            System.out.println("Which action do you want to perform?");
            System.out.print("1 - Play music\n2 - Stop music\n3 - Reset\n4 - Go back\n");
            response = scanner.nextInt();
            switch (response) {
                case 1 -> clip.start();
                case 2 -> clip.stop();
                case 3 -> clip.setMicrosecondPosition(0);
                default ->clip.close();
            }
        }while(response != 4);
    }

}

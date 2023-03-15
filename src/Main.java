import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File Sleep_away = new File("C:\\Users\\renan\\Music\\Arquivos wav\\Sleep-Away.wav");
        File eu_me_lembro = new File("C:\\Users\\renan\\Music\\Arquivos wav\\Eu me Lembro.wav");
        //File just_the_two_of_us = new File("C:\\Users\\renan\\Music\\Arquivos wav\\just-the-two-of-us.wav");
        //File SleepAway = new File("C:\\Users\\renan\\Music\\Arquivos wav\\Sleep-Away.wav");
        AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(Sleep_away);
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(eu_me_lembro);
        //AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(just_the_two_of_us);
        //AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        Scanner scanner = new Scanner(System.in);
        int response;

        System.out.println("Select a song");
        System.out.print("1 - Sleep Away\n2 - Eu Me Lembro\n");
        response = scanner.nextInt();
        switch (response){
            case 1 -> clip.open(audioStream1);
            case 2 -> clip.open(audioStream2);
            //case 3 -> clip.open(audioStream3);
            default -> {}
        }

        do {
            System.out.println("Which action do you want to perform?");
            System.out.print("1 - play music\n2 - stop music\n3 - stop program\n");
            response = scanner.nextInt();
            switch (response) {
                case 1 -> clip.start();
                case 2 -> clip.stop();
                default -> {}
            }
        }while(response != 3);
    }
}

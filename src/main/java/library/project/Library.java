package library.project;

import com.library.exceptions.LibraryException;
import com.library.project.products.*;
import com.library.project.random.MonthRandom;

import java.util.*;

public class Library {

    protected  List <Publication> publications;
    protected Map <Integer, Publication> publicationsMap;

    public Library(int maxBooks) {
        int id = 1;
        publications = new LinkedList<>();
        publicationsMap = new HashMap<>();
        for (int i = 1; i <= maxBooks ; i++) {
            double r = Math.random();
            Publication p = null;
            if (r<0.33){
                p = new Book(i,createTitle(), "TestAuthor", 2022, 24);
            }else if (r<0.66){
                r = Math.random();
                if (r<0.33){
                    p = new Journal(i, createTitle(), MonthRandom.randomMonth());
                } else if (r<0.66) {
                    p = new Newspaper(i, createTitle(), MonthRandom.randomMonth());
                } else {
                    p = new Periodical(i, createTitle(), MonthRandom.randomMonth());
                }
            }else {
                r = Math.random();
                if (r<0.33){
                    p =new Videogame(i, createTitle(), 456);
                }else if (r<0.66){
                    p =new Audiobook(i, createTitle(), 456);
                }else {
                    p =new DVD(i, createTitle(), 456);
                }
            }
            publications.add(p);
            publicationsMap.put(i, p);
        }
    }

    public void add(Publication publication) {
        publications.add(publication);
        publicationsMap.put(publication.getId(),publication);
    }
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        for (Publication p : publications){
            if (p.getClass().equals(Book.class)){
                books.add((Book) p);
            }
        }
        return books;
    }
    public List<Periodical> getPeriodicals(){
        List<Periodical> periodicals = new ArrayList<>();
        for (Publication p : publications){
            if (p instanceof Periodical){
                periodicals.add((Periodical) p);
            }
        }
        return periodicals;
    }
    public List<Journal> getJournals(){
        List<Journal> journals = new ArrayList<>();
        for (Publication p : publications){
            if (Journal.class.isAssignableFrom(p.getClass())){
                journals.add((Journal) p);
            }
        }
        return journals;
    }
    public List<Newspaper> getNewpapers(){
        List<Newspaper> newspapers = new ArrayList<>();
        for(Publication p : publications) {
            if (p instanceof Newspaper){
                newspapers.add((Newspaper) p);
            }
        }
        return newspapers;
    }
    public List<DVD> getDvds(){
        List<DVD> dvds = new ArrayList<>();
        for (Publication p : publications){
            if (p instanceof DVD){
                dvds.add((DVD) p);
            }
        }
        return dvds;
    }
    public List<Audiobook> getAudiobooks(){
        List<Audiobook> audiobooks = new ArrayList<>();
        for (Publication p : publications){
            if ( p instanceof Audiobook){
                audiobooks.add((Audiobook) p);
            }
        }
        return audiobooks;
    }
    public List<Videogame> getVideogames(){
        List<Videogame> videogames = new ArrayList<>();
        for (Publication p : publications) {
            if( p instanceof Videogame){
                videogames.add((Videogame) p);
            }
        }
        return videogames;
    }

    Book getBook(int id) throws LibraryException{
        //check if class matches, cast or throw exception
        Publication p = findById(id);
        if (p instanceof Book){
        } else {
            throw new LibraryException("there is no book with this id");
        }
        //используя эти способы - проверить является ли p Книгой

        // a instanceof ClassA
        // a.getClass().equals()
        // b.getClass().isAssignableFrom()
        System.out.println(p);
        return (Book) p;
    }

    DVD getDVD(int id) throws LibraryException{
        //check if class matches, cast or throw exception
        Publication p = findById(id);
        if (p instanceof DVD){
        } else { throw new LibraryException("there is no DVD with this id");
        }
        System.out.println(p);
        return (DVD) p;
    }

    Periodical getPeriodical(int id) throws LibraryException{
        Publication p = findById(id);
        if (p instanceof Periodical){
        } else {
            throw new LibraryException("there is no Periodical with this id");
        }
        System.out.println(p);
        return (Periodical) p;
    }

    public static String createTitle() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 100; // letter 'z'
        int targetStringLength = 3; // 10
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private Publication findById(int id){
        for (Publication p : publications){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void delete(int id) throws LibraryException {
        Publication p = findById(id);
        if(p==null){
            throw new LibraryException("Не существует записи с id = " + id);
        }
        publications.remove(p);
        publicationsMap.remove(id);
    }

    public static void main(String[] args) {
        Library l = new Library(100);
//
        Videogame g1 = new Videogame(111,"X-Com",3_000_000);
        l.add(g1);

//        Videogame g2 = (Videogame) l.findById(11);
//        System.out.println("Books       : " + l.getBooks());
        System.out.println("Periodicals : " + l.getPeriodicals());
//        System.out.println("Journals    : " + l.getJournals());
//        System.out.println("Newspaper   : " + l.getNewpapers());
//        System.out.println("DVDs        : " + l.getDvds());
//        System.out.println("Audiobooks  : " + l.getAudiobooks());
//        System.out.println("Videogames  : " + l.getVideogames());
//        System.out.println(l.getBook(3));
//
//        try {
//            l.getBook(3);
//        } catch (LibraryException e){
//            System.out.println(e);
//        }
//
//        try {
//            l.getDVD(111);
//        } catch (LibraryException e) {
//            System.out.println(e);
//        }
//
//        try {
//            l.getPeriodical(3);
//        } catch (LibraryException e) {
//            System.out.println(e);
//        }
//        for (int i = 0; i < 12; i++) {
//            System.out.println(Enums.random(MothsOfYear.class));
////
//        }


    }

}


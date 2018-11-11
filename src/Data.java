import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Data {
    private String fileName;
    private ArrayList<Person> people = new ArrayList<Person>();
    private Person current;
    private int index;


    Data()
    {
        this.fileName = "data.csv";
        createPeopleList();
        index = 0;
        try
        {
            this.current = people.get(index);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.toString());
        }
    }

    void sortPeopleBySurname()
    {
        Collections.sort(people, Comparator.comparing(Person::getSurname));
    }
    void nextPerson()
    {
        try
        {
            index++;
            current = people.get(index);
        }
        catch(IndexOutOfBoundsException e)
        {
            index--;
            System.out.println(e.toString());
        }
    }
    void previousPerson()
    {
        try
        {
            index--;
            current = people.get(index);
        }
        catch(IndexOutOfBoundsException e)
        {
            index++;
            System.out.println(e.toString());
        }
    }

    public Person getCurrent() {
        return current;
    }

    void addNewPerson(Person person)
    {
        people.add(person);
    }

    private void createPeopleList()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int counter = 0;
            while((line = reader.readLine()) != null)
            {
                String[] newPerson = line.split(",");
                try {
                    Person person = new Person(newPerson[0], newPerson[1], Integer.parseInt(newPerson[2]));
                    addNewPerson(person);
                }
                catch ( IndexOutOfBoundsException e)
                {
                    System.out.println(e.toString());
                }
            }
        } catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }

    void savePeopleList() {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
            for (Person person : people) {
                writer.write(person.getName() + "," + person.getSurname() + "," + Integer.toString(person.getAge()) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

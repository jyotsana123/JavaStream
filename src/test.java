import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

//Section - 14
//Video - 113. Learn everything about Java Streams
public class test {

	@Test
	
	//Get the count of names which starts with letter "A" without stream
	public void regular()
	{
	ArrayList<String> names = new ArrayList<String>();
	names.add("Abhijeet");
	names.add("Don");
	names.add("Alekhya");
	names.add("Adam");
	names.add("Ram");
	int count = 0;
	for(int i=0; i<names.size(); i++)
	{
		String actual = names.get(i);
		if(actual.startsWith("A"))
		{
			count++;
		}
	}
	System.out.println(count);
}
	@Test
	
	//Get the count of names which starts with letter "A" with stream
	public void streamFilter()
	{
	ArrayList<String> names = new ArrayList<String>();
	names.add("Abhijeet");
	names.add("Don");
	names.add("Alekhya");
	names.add("Adam");
	names.add("Ram");
	
	//There is no life for intermediate operation if there is no terminal operation.
	//Terminal operation will execute only if intermediate operation (filter) returns true.
	//We can create stream
	//How to use filter in Stream API
	long d = names.stream().filter(s->s.startsWith("A")).count();
	System.out.println(d);
	
	//With the help of stream we can store the names.
	//When intermediate operation returns true, then it goes to next step terminal operation
	long c=	Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->
	{
		s.startsWith("A");
	    return true;
	}).count();
	System.out.println(c);
	
	//Print the names which have more than 4 characters.
	names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	
	//Limit the record - If i want only one name which character is more than 4
	names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamMap()
	{
		//Print the name which have last letter as "a" with uppercase
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//If we want all names in uppercase without any filter then we have to use only map not filter.
		
		//Print names which have first letter as "a" with uppercase and sorted.
		Stream.of("Azbhijeet","Don","Alekhya","Adam","Rama").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		
		//You have 2 list, List A & List B, Merge these list into one and then sort it.
		ArrayList<String> name1 = new ArrayList<String>();
		name1.add("Male");
		name1.add("Female");
		name1.add("human");
		
		List<String> name2 = Arrays.asList("Abhijeet","Don","Alekhya","Adam","Rama");
		
		Stream.concat(name1.stream(), name2.stream()).forEach(s-> System.out.println(s));
		
		//Check "Adam" is present in the list or not after merging
	Stream<String> mergedName =	Stream.concat(name1.stream(), name2.stream());
	boolean flag = mergedName.anyMatch(s->s.equalsIgnoreCase("Adam"));
	System.out.println(flag);
	Assert.assertTrue(flag);
	}
	

	@Test
	public void streamCollect()  //collect method is use to collect all the result and convert them into list
	{
		List<String> listString = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).toList();
		List<String> listString1 = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(listString.get(1));
		System.out.println(listString1.get(1));
		
		//Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).limit(0).forEach(s->System.out.println(s));
		
		//Print unique no. from this array
		List<Integer> values = Arrays.asList(3,2,2,4,4,5,6,7,7,8,9);
		values.stream().distinct().forEach(s->System.out.println(s));
		
		//Sort the aaray & get 3rd index value - 2,3,4,5
		List<Integer> values2 = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(values2.get(2));
		
	
}

}


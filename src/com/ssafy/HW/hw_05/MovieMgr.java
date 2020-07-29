package com.ssafy.HW.hw_05;

public class MovieMgr {
	
	private Movie[] movies = new Movie[100];
	private int index;
	
	//Singleton Model
	private static MovieMgr mgr = new MovieMgr();
	
	private MovieMgr() {};	
	
	public static MovieMgr getInstance()
	{
		return mgr;
	}
	
	public void add(Movie m)
	{
		movies[index] = m;
		index++;
	}
	
	public Movie[] search() {
		Movie[] result = new Movie[index];
//		for (int i = 0; i < index; i++)
//		{
//			result[i] = movies[i];
//		}
		System.arraycopy(movies, 0, result, 0, index);
		return result;
	}
	
	public Movie[] searchDirector(String name)
	{
		int idx = 0;
		for (int i = 0; i < index; i++)
		{
			Movie m = movies[i];
			if (m.getDirector().contains(name))
			{
				idx++;
			}
		}

		Movie[] found = new Movie[idx];
		idx = 0;
		for (int i = 0; i < index; i++)
		{
			Movie m = movies[i];
			if (m.getDirector().contains(name))
			{
				found[idx] = m;
				idx++;
			}
		}
		return found;
	}
	
	public Movie[] searchTitle(String name)
	{
		int idx = 0;
		for (int i = 0; i < index; i++)
		{
			Movie m = movies[i];
			if (m.getTitle().contains(name))
			{
				idx++;
			}
		}

		Movie[] found = new Movie[idx];
		idx = 0;
		for (int i = 0; i < index; i++)
		{
			Movie m = movies[i];
			if (m.getTitle().contains(name))
			{
				found[idx] = m;
				idx++;
			}
		}
		return found;
	}

	
	public Movie[] searchGenre(String genre)
	{
		int idx = 0;
		for (int i = 0; i < index; i++)
		{
			Movie m = movies[i];
			if (m.getGenre().contains(genre))
			{
				idx++;
			}
		}
		Movie[] found = new Movie[idx];
		idx = 0;
		for (int i = 0; i < index; i++)
		{
			Movie m = movies[i];
			if (m.getGenre().contains(genre))
			{
				found[idx] = m;
				idx++;
			}
		}
		return found;
	}

	public void delete(String title)
	{
		int i;
		for (i = 0; i < index; i++)
		{
			Movie m = movies[i];
			if (m.getTitle().equals(title))
			{
				break;
			}
		}
		for (i = i+1; i < index; i++)
		{
			movies[i-1] = movies[i];
		}
		
		index--;
	}

	public int getSize() {
		return index;
	}
	
}

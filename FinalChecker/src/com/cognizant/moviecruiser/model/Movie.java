/**
 * 
 */
package com.cognizant.moviecruiser.model;

import java.util.Date;

/**
 * @author Abishiek
 *
 */
public class Movie {

	private long id;
	private String title;
	private long boxOffice;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;

	/**
	 * 
	 */
	public Movie() {
		super();
	}

	/**
	 * @param id
	 * @param title
	 * @param boxOffice
	 * @param active
	 * @param dateOfLaunch
	 * @param genre
	 * @param hasTeaser
	 */
	public Movie(long id, String title, long boxOffice, boolean active,
			Date dateOfLaunch, String genre, boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the boxOffice
	 */
	public long getBoxOffice() {
		return boxOffice;
	}

	/**
	 * @param boxOffice
	 *            the boxOffice to set
	 */
	public void setBoxOffice(long boxOffice) {
		this.boxOffice = boxOffice;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the dateOfLaunch
	 */
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	/**
	 * @param dateOfLaunch
	 *            the dateOfLaunch to set
	 */
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the hasTeaser
	 */
	public boolean isHasTeaser() {
		return hasTeaser;
	}

	/**
	 * @param hasTeaser
	 *            the hasTeaser to set
	 */
	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", boxOffice="
				+ boxOffice + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", genre=" + genre + ", hasTeaser="
				+ hasTeaser + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (int) (boxOffice ^ (boxOffice >>> 32));
		result = prime * result
				+ ((dateOfLaunch == null) ? 0 : dateOfLaunch.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (hasTeaser ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (active != other.active)
			return false;
		if (boxOffice != other.boxOffice)
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (hasTeaser != other.hasTeaser)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}

package metier;

import java.io.Serializable;
import java.util.Date;

public class Encherit implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double prix = 0.0;
    private Internaute internaute = null;
    private Offre offre = null;
    private Date date = null;

    public Encherit(){
    }
    
	public Encherit(Double prix, Date d, Internaute internaute, Offre offre) {
		super();
		this.prix = prix;
		this.internaute = internaute;
		this.offre = offre;
		this.date = d;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Internaute getInternaute() {
		return internaute;
	}

	public void setInternaute(Internaute internaute) {
		this.internaute = internaute;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Encherit [internaute=" + internaute
				+ ", offre=" + offre + ", prix=" + prix + "]";
	}
}

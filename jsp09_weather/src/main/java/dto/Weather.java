package dto;

public class Weather {
	private int stnId;
	private String tmFc;
	private String wfSv1;
	private String wn;
	private String wr;
	
	Weather(){
		super();
	}

	public int getStnId() {
		return stnId;
	}

	public void setStnId(int stnId) {
		this.stnId = stnId;
	}

	public String getTmFc() {
		return tmFc;
	}

	public void setTmfc(String tmFc) {
		this.tmFc = tmFc;
	}

	public String getWfSv1() {
		return wfSv1;
	}

	public void setWfSvl(String wfSv1) {
		this.wfSv1 = wfSv1;
	}

	public String getWn() {
		return wn;
	}

	public void setWn(String wn) {
		this.wn = wn;
	}

	public String getWr() {
		return wr;
	}

	public void setWr(String wr) {
		this.wr = wr;
	}

	@Override
	public String toString() {
		return "weather [stnId=" + stnId + ", tmFc=" + tmFc + ", wfSv1=" + wfSv1 + ", wn=" + wn + ", wr=" + wr + "]";
	}
	
	
}

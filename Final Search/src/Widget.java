
public class Widget implements Comparable<Widget> {

	private int code;
	private int sold;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public Widget(int code, int sold) {
		super();
		this.code = code;
		this.sold = sold;
	}
	@Override
	public int compareTo(Widget o) {
		return getSold() - o.getSold();
	}
}

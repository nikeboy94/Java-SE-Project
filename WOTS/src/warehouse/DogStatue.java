package warehouse;

public class DogStatue extends Product{
	
	private String meme;
	
	public DogStatue(int productID, int location, String name, String meme){
		super(productID, location, name);
		this.meme = meme;
	}
	
	/** Second Constructor for less specific details, for use on Order Form's.**/
	public DogStatue(String name, String meme, boolean isProtected) {
		super(name, isProtected);
		this.meme = meme;
	}

	public String getMeme() {
		return meme;
	}
	
}

package domain.user;

public class Name {
	private static final String BLANK = " ";
	private static final String EMPTY_ERROR = "이름이 비어있다.";
	private static final String BLANK_ERROR = "이름에 공백이 존재한다.";

	private final String name;
	
	public Name(String name) {
		validate(name);
		this.name = name;
	}
	
	public static void validate(String name) {
		checkEmpty(name);
		checkBlank(name);
	}
	
	private static void checkEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR);
		}
	}
	
	private static void checkBlank(String name) {
		if (name.contains(BLANK)) {
			throw new IllegalArgumentException(BLANK_ERROR);
		}
	}

	public String get() {
		return name;
	}
}

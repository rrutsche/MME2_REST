package domain;

public class FilterSuccess {
	
	private boolean success;
	private String message;
	private Filter filter;

	public FilterSuccess() {
	}

	public boolean isSuccess() {
		return success;
	}

	public FilterSuccess setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public FilterSuccess setMessage(String message) {
		this.message = message;
		return this;
	}

	public Filter getFilter() {
		return filter;
	}

	public FilterSuccess setFilter(Filter filter) {
		this.filter = filter;
		return this;
	}
	
	

}

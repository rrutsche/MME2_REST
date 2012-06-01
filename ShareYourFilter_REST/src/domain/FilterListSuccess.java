package domain;

public class FilterListSuccess {
	
	private boolean success;
	private String message;
	private Filter[] filters;

	public FilterListSuccess() {
	}

	public boolean isSuccess() {
		return success;
	}

	public FilterListSuccess setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public FilterListSuccess setMessage(String message) {
		this.message = message;
		return this;
	}

	public Filter[] getFilters() {
		return filters;
	}

	public void setFilters(Filter[] filters) {
		this.filters = filters;
	}

	
	

}

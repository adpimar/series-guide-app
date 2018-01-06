package impl.managers.remote.thetvdb.jsonschemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"first", 
	"last", 
	"next", 
	"prev" })
public class Links {

	@JsonProperty("first")
	private Integer first;

	@JsonProperty("last")
	private Integer last;

	@JsonProperty("next")
	private Object next;

	@JsonProperty("prev")
	private Object prev;

	// ------------------------------------------------------------------------
	
	@JsonProperty("first")
	public Integer getFirst() {
		return first;
	}

	@JsonProperty("first")
	public void setFirst(Integer first) {
		this.first = first;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("last")
	public Integer getLast() {
		return last;
	}

	@JsonProperty("last")
	public void setLast(Integer last) {
		this.last = last;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("next")
	public Object getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(Object next) {
		this.next = next;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("prev")
	public Object getPrev() {
		return prev;
	}

	@JsonProperty("prev")
	public void setPrev(Object prev) {
		this.prev = prev;
	}

}
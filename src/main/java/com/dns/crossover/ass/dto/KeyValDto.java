package com.dns.crossover.ass.dto;


/**
 * @author dinusha
 *
 */
public class KeyValDto
{
	private String key;
	private String value;

	public KeyValDto()
	{
	}

	public KeyValDto(String key, String value)
	{
		this.key = key;
		this.value = value;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		if(!(obj instanceof KeyValDto))
			return false;
		return getKey().equals(((KeyValDto)obj).getKey());
	}

	@Override
	public String toString()
	{
		return value + "(" + key + ")";
	}

}

/**
 * 
 */
package com.cobee.rentalhousems.util;

import java.math.BigDecimal;

/** <pre>处理数字的工具类</pre>
 * @author 陈淦森
 * @version 1.0.1
 * @date 2016年12月24日
 *
 */
public class NumericUtils {

	private NumericUtils()
	{
		throw new IllegalStateException("工具类，不需要创建");
	}

	/**
	 * <pre>判断整型对像是否为空，并且要大于0</pre>
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2016年12月24日
	 *
	 * @param i
	 * @return
	 */
	public static boolean isNotNullAndGT0(Integer i)
	{
		return (i != null && i > 0);
	}

	/**
	 *	判断传入的值是否小于某个值
	 *
	 * @param val
	 * @param i
     * @return
     */
	public static boolean isLT(Integer val, Integer i)
	{
		if (val == null || i == null)
		{
			return false;
		}
		return val < i;
	}
	public static boolean isLT(Double val, Double i)
	{
		if (val == null || i == null)
		{
			return false;
		}
		return val < i;
	}
	/**
	 * <pre>是否大于0，null安全</pre>
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2017年4月27日
	 *
	 * @param d
	 * @return
	 */
	public static boolean isGt0(Double d)
	{
		return (d != null && d > 0);
	}

	/**
	 * <pre>是否大于0，null安全</pre>
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2017年4月27日
	 *
	 * @param i
	 * @return
	 */
	public static boolean isGt0(Integer i)
	{
		return (i != null && i > 0);
	}

	/**
	 * 是否大于某个值
	 * @param val
	 * @param val1
     * @return
     */
	public static boolean isGt(Integer val, Integer val1)
	{
		if (val == null || val1 == null)
		{
			return false;
		}
		if (val > val1)
		{
			return true;
		}
		return false;
	}
	public static boolean isGt(Double val, Double val1)
	{
		if (val == null || val1 == null)
		{
			return false;
		}
		if (val > val1)
		{
			return true;
		}
		return false;
	}
	public static boolean equal(Integer i1, Integer i2)
	{
		if (i1 == null || i2 == null) return false;
		if (i1.equals(i2)) return true;
		return false;
	}

	public static boolean equal(Long i1, Long i2)
	{
		if (i1 == null || i2 == null) return false;
		if (i1.equals(i2)) return true;
		return false;
	}

	public static boolean notEqual(Integer i1, Integer i2)
	{
		return !equal(i1, i2);
	}
	
	public static boolean equalOr(Integer i1, Integer... i2)
	{
		if (i1 == null || i2 == null) return false;
		for (Integer tmpi : i2)
		{
			if (i1.equals(tmpi))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean equal(Double d1, Double d2)
	{
		if (d1 == null || d2 == null) return false;
		if (d1.equals(d2)) return true;
		return false;
	}
	
	public static Double getSaveDouble(Double d)
	{
		if (d == null)
		{
			return new Double(0.0D);
		}
		return d;
	}

	public static Double toDoubleValue(Object object)
	{
		if (object == null)
		{
			return new Double(0.0D);
		}

		if (object instanceof Double)
		{
			return (Double) object;
		}

		else if (object instanceof BigDecimal)
		{
			return ((BigDecimal) object).doubleValue();
		}

		return new Double(0.0D);
	}
	
	public static Integer getSaveInteger(Integer i)
	{
		if (i == null)
		{
			return new Integer(0);
		}
		return i;
	}

	/**
	 * 给定值是否在范围之里，包含等于
	 * <code>i >= val1 && i <= val2</code>
	 * @param i
	 * @param val1
	 * @param val2
     * @return
     */
	public static boolean isBetween(Integer i, Integer val1, Integer val2)
	{
		if (i == null)
		{
			return false;
		}
		else
		{
			if (i >= val1 && i <= val2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	/**
	 * 给定值是否在范围之里，val1包含等于，val2不包含等于
	 * <code>i >= val1 && i < val2</code>
	 * @param i
	 * @param val1
	 * @param val2
     * @return
     */
	public static boolean isBetween1(Integer i, Integer val1, Integer val2)
	{
		if (i == null)
		{
			return false;
		}
		else
		{
			if (i >= val1 && i < val2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	/**
	 * 给定值是否在范围之里，val1不包含等于, val2包含等于
	 * <code>i > val1 && i <= val2</code>
	 * @param i
	 * @param val1
	 * @param val2
     * @return
     */
	public static boolean isBetween2(Integer i, Integer val1, Integer val2)
	{
		if (i == null)
		{
			return false;
		}
		else
		{
			if (i > val1 && i <= val2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
}

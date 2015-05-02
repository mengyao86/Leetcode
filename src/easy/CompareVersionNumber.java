package easy;

public class CompareVersionNumber {

	public int compareVersion(String version1, String version2) {

		String[] lVersion1 = version1.split("\\.");

		String[] lVersion2 = version2.split("\\.");

		int lRe = 0;

		int lLength = lVersion1.length > lVersion2.length ? lVersion2.length
				: lVersion1.length;
		for (int i = 0; i < lLength; i++) {
			if (Integer.parseInt(lVersion1[i]) > Integer.parseInt(lVersion2[i])) {
				lRe = 1;
				break;
			} else if (Integer.parseInt(lVersion1[i]) < Integer.parseInt(lVersion2[i])) {
				lRe = -1;
				break;
			} else {
				continue;
			}
		}
		
		if( lRe == 0 && lVersion1.length != lVersion2.length  )
		{
			if(lVersion1.length >lVersion2.length) 
			{
				int extra = lVersion1.length -lVersion2.length;
				for( int i=0; i< extra; i++)
				{
					if(  Integer.parseInt(lVersion1[lVersion2.length +i] )>0)
					{
						lRe = 1;

					}
				}
			}
			else
			{
				int extra = lVersion2.length -lVersion1.length;
				for( int i=0; i< extra; i++)
				{
					if(  Integer.parseInt(lVersion2[lVersion1.length +i] )>0)
					{
						lRe = -1;

					}
				}
			}
		}

		return lRe;

	}

	public static void main(String[] args) {
		CompareVersionNumber lCompareVersionNumber = new CompareVersionNumber();
		System.out.println(lCompareVersionNumber.compareVersion("1.0",
				"1"));
	}
}

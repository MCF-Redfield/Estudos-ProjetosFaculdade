package binariarecursiva;
public class BinariaRecursiva
{
 
    private static int binarySearch( Comparable [ ] a, Comparable x,
                                     int low, int high )
    {
        boolean existe;
        if( low > high )
            return existe;

        int mid = ( low + high ) / 2;

        if( a[ mid ].compareTo( x ) < 0 )
            return binarySearch( a, x, mid + 1, high );
        else if( a[ mid ].compareTo( x ) > 0 )
            return binarySearch( a, x, low, mid - 1 );
        else
            return mid;
    }

    // Programa teste
    public static void main( String [ ] args )
    {
        int SIZE = 8;
        Comparable [ ] a = new Integer [ SIZE ];
        for( int i = 0; i < SIZE; i++ )
            a[ i ] = new Integer( i * 2 );

        for( int i = 0; i < SIZE * 2; i++ )
            System.out.println( "Encontrado " + i + " em " +binarySearch( a, new Integer( i ) ) );
    }
}


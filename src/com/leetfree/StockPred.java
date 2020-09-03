package com.leetfree;

import java.util.ArrayList;
import java.util.List;

/**
 * Stock pred hackerrank
 */
public class StockPred {
    public static void main(String[] args) {
        int[] stockPrice = {5,6,8,4,9,10,8,3,6,4};
        int[] big ={89214	,
            26671	,
            75144	,
            32445	,
            13656	,
            66289	,
            21951	,
            10265	,
            59857	,
            59133	,
            63227	,
            86121	,
            37411	,
            54628	,
            25859	,
            43510	,
            63756	,
            54763	,
            30852	,
            53243	,
            76238	,
            96885	,
            33074	,
            17745	,
            81814	,
            43436	,
            79172	,
            92819	,
            30001	,
            68442	,
            54021	,
            35566	,
            95113	,
            29164	,
            84362	,
            25120	,
            11804	,
            6313	,
            51736	,
            71661	,
            81797	,
            14962	,
            57781	,
            35560	,
            85941	,
            99991	,
            95421	,
            66048	,
            54754	,
            26272	,
            35642	,
            47343	,
            39508	,
            85068	,
            65087	,
            21321	,
            28503	,
            60611	,
            30491	,
            58503	,
            29052	,
            84512	,
            94069	,
            40516	,
            13675	,
            78430	,
            65635	,
            25479	,
            1094	,
            17370	,
            13491	,
            99243	,
            48683	,
            71271	,
            34802	,
            34624	,
            87613	,
            46574	,
            671	,
            42366	,
            89197	,
            36313	,
            89708	,
            28704	,
            21380	,
            54795	,
            66376	,
            49882	,
            15405	,
            96867	,
            24737	,
            60808	,
            81378	,
            35157	,
            1324	,
            11404	,
            29938	,
            66958	,
            53234	,
            47384	
            };
        int[] bigQ ={50	,
            80	,
            24	,
            26	,
            62	,
            46	,
            79	,
            85	,
            59	,
            52	,
            8	,
            76	,
            48	,
            72	,
            84	,
            3	,
            3	,
            30	,
            30	,
            36	,
            86	,
            96	,
            72	,
            93	,
            25	,
            28	,
            68	,
            81	,
            18	,
            78	,
            14	,
            1	,
            57	,
            90	,
            26	,
            18	,
            87	,
            56	,
            55	,
            97	,
            59	,
            62	,
            73	,
            58	,
            85	,
            8	,
            60	,
            87	,
            89	,
            89	,
            22};
        int[] queries = {3,1,8};

        List<Integer> result = new ArrayList<>();
        for(int i : bigQ){
            result.add(getResult(big,i));
        }
        System.out.println(result);
    }

    private static int getResult(int[] stockPrice, int q) {
        int thePoint = q-1;
        int i = thePoint-1;
        int j = q;
        int theValue = stockPrice[thePoint];

        while(i>=0 && j<=stockPrice.length-1){
            int leftValue = stockPrice[i];
            int rightValue = stockPrice[j];
            if(leftValue < theValue){
                return i+1;
            } else if(rightValue < theValue){
                return j+1;
            }
            i -=1;
            j +=1;
        }
        //edge case
        
        if(i >=0){
            while(i >=0){
                int leftValue = stockPrice[i];
                if(leftValue<theValue){
                    return i+1;
                }
                i -=1;
            }
            
        }

        if(j <= stockPrice.length-1){
            while(j <=stockPrice.length-1){
                int rightValue = stockPrice[j];
                if(rightValue<theValue){
                    return j+1;
                }
                j +=1;
            }
        }

        return -1;
    }
}
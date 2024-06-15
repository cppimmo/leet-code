#!/usr/bin/php
<?php
error_reporting(E_ERROR | E_PARSE);
 
class Solution
{
    /**
     * @param String $paragraph
     * @param String[] $banned
     * @return String
     */
    function mostCommonWord($paragraph, $banned)
    {
        $delimeters = explode('|', ' |!|?|\'|,|;|.|"');
        $unbannedWords = array();
    
        for ($word = '', $i = 0; $i < strlen($paragraph); ++$i) {
            $isDelim = in_array($paragraph[$i], $delimeters);
            if (!$isDelim)
                $word .= $paragraph[$i];

            if (!empty($word) && ($isDelim || $i == strlen($paragraph) - 1)) {
                $word = strtolower($word);
                if (!in_array($word, $banned))
                    $unbannedWords[$word]++;

                $word = '';
            }
        }

        //foreach ($unbannedWords as $k => $v)
        //    echo "$k : $v\n";

        if (!empty($unbannedWords))
            return array_search(max($unbannedWords), $unbannedWords);
        else
            return '';
    }
}
// Test cases
$paragraphs = [
     'Bob hit a ball, the hit BALL flew far after it was hit.',
     'a.'
];

$banned = [
    ['hit'],
    []
];
// Run test cases
for ($i = 0; $i < count($paragraphs); $i++) {
    fwrite(STDOUT, (new Solution())->mostCommonWord($paragraphs[$i], $banned[$i]) . "\n");
}

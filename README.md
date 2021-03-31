# SimpleJWPlayerAndroidExample

You are provide 


Video URL: http://103.89.68.179:1935/mediacache/_definst_/smil:path1/67d1f04e-71a4-4744-a8c9-c1c85f08f508.smil/playlist.m3u8 

Ads URL: http://103.89.68.180/storage/v_a/xml/20012ea4-aa0e-4762-a21a-9a664d09e914.xml  


I was got a problem with the 'Ads URL' 
when I tested ads url from https://developers.google.com/interactive-media-ads/docs/sdks/html5/client-side/vastinspector 
I was gettting some error message .
In fact, the problem was in the video url ( http://103.89.68.91/ads/20012ea4-aa0e-4762-a21a-9a664d09e914.mp4) inside the XML file .
so I changed video url inside xml file and upload it on github .
And use github url as a ads url
And it's work fine 


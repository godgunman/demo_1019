demo_1019
=========

A demo app for tech talk at NTHU.

### STEP 0

* 下載 [Android SDK](http://developer.android.com/sdk/index.html#download)
* 註冊 [Parse](https://parse.com/)
* 準備好裝置（擇1即可）
  * 使用實體手機
    * 打開除錯模式
    * [Run on a Real Device](http://developer.android.com/training/basics/firstapp/running-app.html#RealDevice)
    * [參考連結](https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=android+debug+mode)
  * 使用模擬器（擇1即可）
    * 使用 Android SDK 內建的模擬器
    	* [Run on the Emulator](http://developer.android.com/training/basics/firstapp/running-app.html#Emulator)
	    * [如何啟動 Android SDK Manager，安裝多種版本 SDK，並且建立 AVD](http://www.inote.tw/android-sdk-manage	)
> 因為最新版的 Android SDK 包含的模擬器映像檔是 Android 4.4W（是穿戴式裝置用的）所以比較不適合我們開發，所以要下載 Android 4.4.2 或者 Android 5 的映像檔） 
    * 使用 Genymotion
	    * [Genymotion 官網](http://www.genymotion.com/)
	    * [【情報】Genymotion模擬器使用教學](http://forum.gamer.com.tw/C.php?bsn=24764&snA=2863)
	    
	    
### STEP 1
* 開新專案
	1. 開啟 Eclipse
	2. File -> New -> Android Application Project
	3. Minimum Required SDK 選 4.0
	4. 帶著勇氣的一直按 Next
> [Platform Versions](http://developer.android.com/about/dashboards/index.html) Android 官網統計顯示，Android 2.3 以下的機型市佔率低於 13 %。主流版本還是 Android 4.0 以上。
* 將專案執行在裝置上（實體手機或者是模擬器）
	1. 對專案按右鍵 -> Run As -> Android Application 

<!-- ![step1_1](http://i.imgur.com/a2a2b1b.png =250x)
![step1_2](http://i.imgur.com/JJHpfYA.png =250x)
		 -->
# parent-tv
父母TV

~~~
Android Studio
JDK
播放器SDK

针对电视的大屏幕进行布局优化
还可以使用Android TV的特殊功能和界面元素来增强你的应用程序
分辨率适配

遥控器
	焦点
		要想让RecyclerView重新获得焦点后，选中上次的item。使用HorizontalGridView或者VerticalGridView


模拟器
	MuMu
	ChromeADB

需电视开发者选项授权
adb无线调试的常用命令：
	# 工作机与电视同处一个网络下，shell / cmd 输入
	# 连接设备
	adb connect 电视机ip
	# 断开连接
	adb disconnect 电视机ip
	# adb 安装 
	adb install -r "apk在你电脑上的路径"
	# adb 卸载
	adb uninstall 应用的packagename
~~~

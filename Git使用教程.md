**git使用教程**

基础：
		1 初始化：git init

		2 账号名字和邮件输入：

			git config --global user.email "你的邮箱"
			git config --global user.name "你的名字"

		3
			1、在本机添加文件，echo "测试本机与远程库" >> test.txt;

			2、进入chengfeng库中，输入命令：git add test.txt；

			3、查看文件状态，git status，则test.txt为new状态；

			4、提交文件到缓存区，输入命令：git commit -m “测试文件”；

			5、提交到远程库，输入命令：git push -u origin master




git删除远程仓库文件


			1.先在本地git清除文件夹

			　　git rm xxx(xxx表文件名)  -r ( -r 当给出主目录名时允许递归删除)

			2.本地提交 

			　　git commit -m''(-m 备注)

			3.最后push到远程仓库

			　　git push -u origin master

恢复本地仓库的文件	
			1 查看删除文件的缓冲状态：
							 git status
				
			2 删除文件查看 ：
							git reset HEAD

			3 删除文件恢复：
						 git checkout   文件或者文件名称







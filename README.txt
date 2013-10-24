Name   : Ionescu Eugen-Andrei
E-mail : eugen.a.ionescu@gmail.com



			Android SimpleDemo App

Index : 

1 - Description
1.1 -- Information about the App
1.2 -- Tools
2 - Components
2.1 -- Activities

================================================================================
			1. Description

		1.1 Information about the App

	This project was created as a basic demo of an Android app vith a few
	examples of the types of activities a beginner (such as myself) can 
	create to learn the basics of programming on a mobile platform . 
	
	I started this project while studying Android as an Intern. This is by no
	means a complete or perfect example of a mobile app , it's just a first 
	attempt at learning something new.
		
		1.2 Tools

	This App was developed using the Android Developer Tools plugin for 
	eclipse [1] .

	The support library Action Bar Sherlock [2] is used for backwards 
	compatibility with earlier versions of Android where the Action Bar is 
	not supported.

	[1]http://developer.android.com/develop/index.html
	[2]http://actionbarsherlock.com/

================================================================================
			2. Components

		2.1 Main Activities

	- Menu Demo
	
	This ListActivity that displays a list of strings that can be edited 
	using a	context menu and a menu displayed on the action bar.

	- Form Demo

	TODO : add a menu for persistent prefferences that change the display
	pattern

	- Resource Demo

	A simple game of memory using icons .
	Nuff' said.

	- Fragment Demo

	An activity used for andvanced web searches . This demo uses fragments to
	show up differently on portrait and landscape screen orientations . 
	The first fragment allows the user to toggle safe searching , type a 
	regular search string , type a list of terms that must be included in the
	final result and a list of search terms that should be excluded from the 
	search.

	In landscape orientation both fragments share the screen .
	In portrait Orientation the search term fragment appears first and gets
	replaced by a WebView after pressing the "Search" button.

	Navigation controls (Forward , Back , Refresh) are shown in the ActionBar.
 

	- Design Demo
	
	Simple Activity with a slightly more complex design than the others.
	A couple of tabs , one of them with several nested Layouts.


================================================================================


================================================================================
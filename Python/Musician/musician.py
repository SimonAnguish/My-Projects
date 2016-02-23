#!/usr/bin/python

import urllib
import re

def getSongList(musician):
	musician_first_initial = musician[0].lower()
	link = "http://www.azlyrics.com/" + musician_first_initial + "/" + musician.lower() + ".html"
	f = urllib.urlopen(link)
	myfile = f.read()
	firstSplit = myfile.split('var songlist = [',1)[1]
	raw = firstSplit.split('];',1)[0]
	names_regex = re.compile('[a-z]+')
	print names_regex.match('word').group(0)
	

	
getSongList("Sia")
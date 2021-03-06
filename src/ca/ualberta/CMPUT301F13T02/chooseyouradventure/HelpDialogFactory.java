/*
* Copyright (c) 2013, TeamCMPUT301F13T02
* All rights reserved.
* 
* Redistribution and use in source and binary forms, with or without modification,
* are permitted provided that the following conditions are met:
* 
* Redistributions of source code must retain the above copyright notice, this
* list of conditions and the following disclaimer.
* 
* Redistributions in binary form must reproduce the above copyright notice, this
* list of conditions and the following disclaimer in the documentation and/or
* other materials provided with the distribution.
* 
* Neither the name of the {organization} nor the names of its
* contributors may be used to endorse or promote products derived from
* this software without specific prior written permission.
* 
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
* ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
* WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
* ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package ca.ualberta.CMPUT301F13T02.chooseyouradventure;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;

/**
 * This class is responsible for creating help Dialogs for use in the views of this application
 * 
 * This class employs the Factory design pattern
 * 
 * @author Konrad Lindenbach
 */

public class HelpDialogFactory {

	/**
	 * Creates and returns an AlertDialog for the help feature
	 * 
	 * @param text The id of a string to display in the WebView
	 * @param context The context of the new AlertDialog
	 * @return An AlertDialog displaying the passed string
	 * @author Konrad Lindenbach
	 */
	public static AlertDialog create(int id, Context context) {

		ScrollView scrollView = (ScrollView) View.inflate(context, R.layout.help_dialog, null);
		WebView view = (WebView) scrollView.findViewById(R.id.help_webview);

		view.loadData(context.getString(id), "text/html; charset=utf-8", "UTF-8");
        
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.help);
        builder.setPositiveButton(R.string.ok, null);
        builder.setView(scrollView);
        //builder.show();

        return builder.create();
	}
}

/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.android.wallpaper.picker.customization.ui.viewmodel

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import com.android.wallpaper.module.CustomizationSections

/**
 * Interface for a view model that can store the animation state for use after a configuration
 * change restart.
 */
abstract class AnimationStateViewModel : ViewModel() {
    /**
     * Used to persist the preview section loading animation state through config change restarts
     */
    private var homePreviewDrawable: Drawable? = null
    private var lockPreviewDrawable: Drawable? = null

    fun saveAnimationState(screen: CustomizationSections.Screen, drawable: Drawable?) {
        if (screen == CustomizationSections.Screen.LOCK_SCREEN) {
            lockPreviewDrawable = drawable
        } else {
            homePreviewDrawable = drawable
        }
    }

    fun getAnimationState(screen: CustomizationSections.Screen): Drawable? {
        return if (screen == CustomizationSections.Screen.LOCK_SCREEN) {
            lockPreviewDrawable
        } else {
            homePreviewDrawable
        }
    }
}

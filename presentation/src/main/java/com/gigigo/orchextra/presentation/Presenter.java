/*
 * Created by Orchextra
 *
 * Copyright (C) 2016 Gigigo Mobile Services SL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gigigo.orchextra.presentation;

import me.panavtec.threaddecoratedview.views.ThreadSpec;
import me.panavtec.threaddecoratedview.views.ViewInjector;

public abstract class Presenter<V> {

  private V view;
  private ThreadSpec mainThreadSpec;

  public Presenter(ThreadSpec mainThreadSpec) {
    this.mainThreadSpec = mainThreadSpec;
  }

  public void attachView(V view) {
    this.view = ViewInjector.inject(view, mainThreadSpec);
    onViewAttached();
  }

  public void detachView() {
    this.view = ViewInjector.nullObjectPatternView(view);
  }

  public V getView() {
    return view;
  }

  public abstract void onViewAttached();
}
